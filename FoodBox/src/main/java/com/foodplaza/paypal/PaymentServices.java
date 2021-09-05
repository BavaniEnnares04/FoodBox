package com.foodplaza.paypal;

import java.util.ArrayList;
import java.util.List;
import com.foodplaza.dao.CartDaoImp;
import com.foodplaza.dao.CustomerDaoImp;
import com.foodplaza.dao.FoodDaoImp;
import com.foodplaza.model.Cart;
import com.foodplaza.model.Customer;
import com.foodplaza.model.Food;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

public class PaymentServices {
	private static final String CLIENT_ID = "AVZrAMbWVi53HhhojXkWxyx5JdpRz93LdGeT_h21pPKQ6X6Y2uv9cBA4t9w_yfN1dc7YrKTZ3Wt-ybpK";
	private static final String CLIENT_SECRET = "ED6fdAs5xlTBVas7rhbXTcAV-vbKQR7MkA4PirmvOMWIxaj32qabcD5E0BgyCpHQ-Ew-GV1eKELvBniS";
	private static final String MODE = "sandbox";

	public String authorizePayment(List<Cart> listOfFoodInCart) throws PayPalRESTException {

		Payer payer = getPayerInformation(listOfFoodInCart.get(0));
		RedirectUrls redirectUrls = getRedirectURLs();
		List<Transaction> listTransaction = getTransactionInformation(listOfFoodInCart);

		Payment requestPayment = new Payment();
		requestPayment.setTransactions(listTransaction);
		requestPayment.setRedirectUrls(redirectUrls);
		requestPayment.setPayer(payer);
		requestPayment.setIntent("authorize");

		APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
		Payment approvedPayment = requestPayment.create(apiContext);
		return getApprovalLink(approvedPayment);

	}

	private Payer getPayerInformation(Cart userFromCart) {
		Customer user=new CustomerDaoImp().getCustById(userFromCart.getEmail());
		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");

		PayerInfo payerInfo = new PayerInfo();
		payerInfo.setFirstName(user.getCustName()).setEmail(userFromCart.getEmail());

		payer.setPayerInfo(payerInfo);

		return payer;
	}

	private RedirectUrls getRedirectURLs() {
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl("http://localhost:8080/FoodPlaza/cancel.jsp");
		redirectUrls.setReturnUrl("http://localhost:8080/FoodPlaza/review_payment");
		//redirectUrls.setReturnUrl("http://localhost:8080/FoodPlaza/review.jsp");

		return redirectUrls;
	}

	private List<Transaction> getTransactionInformation(List<Cart> cartDetail) {
		
		List<Transaction> listTransaction = new ArrayList<Transaction>();
//		String shippingAddress=new UserDaoImp().getUserByUserId(cartDetail.get(0).getUserId()).getUserAddress();
		Details details = new Details();
		details.setShipping("40");
        details.setSubtotal(String.valueOf(new CartDaoImp().totalPriceFromCart(cartDetail.get(0).getEmail())));
        details.setTax("10");
        System.out.println("total from cart :"+String.valueOf(new CartDaoImp().totalPriceFromCart(cartDetail.get(0).getEmail())));
        double total=40+10+new CartDaoImp().totalPriceFromCart(cartDetail.get(0).getEmail());
        System.out.println("Total: "+total);
		Amount amount = new Amount();
		amount.setCurrency("USD");
		amount.setTotal(String.valueOf(total));
		amount.setDetails(details);

		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setDescription("FOOD PLAZA");

		ItemList itemList = new ItemList();
		List<Item> items = new ArrayList<Item>();

		for(Cart c: cartDetail)
		{
			Food f=new FoodDaoImp().getFoodById(c.getFoodId());
			Item item = new Item();
			item.setCurrency("USD");
			item.setName(f.getFoodName());
			item.setQuantity(String.valueOf(c.getQuantity()));
			item.setPrice(String.valueOf(c.getPrice()));

			items.add(item);
		}
		
		itemList.setItems(items);
		transaction.setItemList(itemList);

		
		listTransaction.add(transaction);

		return listTransaction;
	}

	private String getApprovalLink(Payment approvedPayment) {
		List<Links> links = approvedPayment.getLinks();
		String approvalLink = null;

		for (Links link : links) {
			if (link.getRel().equalsIgnoreCase("approval_url")) {
				approvalLink = link.getHref();
				break;
			}
		}
		System.out.println(approvalLink);
		return approvalLink;
	}

	public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
		APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
		return Payment.get(apiContext, paymentId);
	}

	public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
		PaymentExecution paymentExecution = new PaymentExecution();
		paymentExecution.setPayerId(payerId);

		Payment payment = new Payment().setId(paymentId);

		APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

		return payment.execute(apiContext, paymentExecution);
	}

}
