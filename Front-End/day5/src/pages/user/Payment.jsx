import React from 'react';
import { useNavigate, useParams } from 'react-router-dom'; 
import '../../assets/css/payment.css';

const PaymentPage = () => {
  const { amount } = useParams(); 
const navigate=useNavigate();
  const handlePay = () => {
      console.log('Payment successful');
      navigate('/payment-success');
  };

  return (
    <div className="payment-page">
      <h2>Payment Page</h2>
      <p>Please proceed with the payment of ${amount}.</p>
      <button onClick={handlePay}>Pay</button>
    </div>
  );
};

export default PaymentPage;
