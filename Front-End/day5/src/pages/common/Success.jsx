import React from 'react';
import { Link } from 'react-router-dom';
import '../../assets/css/NotFound.css'; // Import your CSS file

const Success = () => (
  <div className="not-found">
    <h1>Payment Successfull</h1>
    <Link to="/">Go back to Home</Link>
  </div>
);

export default Success;
