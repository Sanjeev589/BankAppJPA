package com.cg.bankapplication.DAO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import com.cg.bankapplication.bean.Customer;
import com.cg.bankapplication.bean.Transaction;

public class BankApplicationDAOImp implements BankApplicationDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
    EntityManager entityManager = factory.createEntityManager();
	public Customer createCustomerAcc(Customer customer) {
		entityManager.getTransaction().begin();
		Query query = entityManager.createNativeQuery("select customerIDSeq.nextval from dual");
        BigDecimal transint =(BigDecimal) query.getSingleResult();
        long custID = transint.longValue();
        customer.setCustomerId(custID);
		entityManager.persist(customer);
		entityManager.getTransaction().commit();
		return customer;
	}

	@Override
	public boolean deleteCustomerAcc(long accountNo) {
		
		TypedQuery<Customer> query = entityManager.createQuery("from Customer where accountNo=? ", Customer.class);
		query.setParameter(1,accountNo);
		entityManager.getTransaction().begin();
		Customer customer = query.getSingleResult();
		entityManager.remove(customer);
		entityManager.getTransaction().commit();
		return true;
	}

	@Override
	public double debit(long accountNo, double amount) {
		TypedQuery<Customer> query = entityManager.createQuery("from Customer where accountNo=? ", Customer.class);
		query.setParameter(1,accountNo);
		entityManager.getTransaction().begin();
		Customer customer = query.getSingleResult();
		double current_bal = customer.getBalance();
		double new_bal = current_bal - amount ;
		customer.setBalance(new_bal);
		entityManager.getTransaction().commit();
		entityManager.clear();
		return customer.getBalance();	
	}

	@Override
	public boolean credit(long accountNo, double amount) {
		TypedQuery<Customer> query = entityManager.createQuery("from Customer where accountNo=? ", Customer.class);
		query.setParameter(1,accountNo);
		entityManager.getTransaction().begin();
		Customer customer = query.getSingleResult();
		double current_bal = customer.getBalance();
		double new_bal = current_bal + amount ;
		customer.setBalance(new_bal);
		entityManager.getTransaction().commit();
		entityManager.clear();
		return true;
	}
	@Override
	public List<Transaction> getTransactionDetails(long accountNo) {
		List<Transaction> trans = new ArrayList<Transaction>();
		
		TypedQuery<Transaction> query = entityManager.createQuery("from Transaction where customerAccountNo = ? order by date desc", Transaction.class);
		query.setParameter(1,accountNo);
		trans = query.getResultList();
		entityManager.clear();
		return trans;
	}

	@Override
	public Customer getCustomerAccountDetails(long accountNo) {
		TypedQuery<Customer> query = entityManager.createQuery("from Customer where accountNo=? ", Customer.class);
		query.setParameter(1,accountNo);
		List<Customer> customers = query.getResultList();
		Customer customer1 = null;
		if(customers.isEmpty() || customers == null)
		 return null; 
		else {
			for (Customer customer : customers) {
				customer1 = customer;
			}
			entityManager.clear();
			return customer1;
	}
	}

	@Override
	public boolean addTransaction(Transaction trans) {
		Query query = entityManager.createNativeQuery("select transIDSeq.nextval from dual");
        BigDecimal transint =(BigDecimal) query.getSingleResult();
        String transactionNo="txn"+transint.toString();
        trans.setTransactionId(transactionNo);
        entityManager.getTransaction().begin();
		entityManager.persist(trans);
		entityManager.getTransaction().commit();
		entityManager.clear();
		return false;
	}
}
