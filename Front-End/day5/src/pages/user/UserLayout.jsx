import React from 'react';
import { useNavigate } from 'react-router-dom'; // Import useNavigate hook for navigation
import '../../assets/css/userLayout.css'
function UserLayout({ children }) {
  const navigate = useNavigate();

  const handleLogout = () => {
    sessionStorage.clear();
    navigate('/login');
  };

  return (
    <div className="user-layout">
      <header className="header sticky"> {/* Add 'sticky' class for stickiness */}
        <h1>Party Planner</h1>
        <button onClick={handleLogout}>Logout</button>
      </header>
      <nav className="navbar">
        <ul>
          <li><a href="/">Events</a></li>
          <li><a href="/bookingform">Booking</a></li>
          <li><a href="/venue">Venue</a></li>
          <li><a href="/cart">Cart</a></li>
        </ul>
      </nav>
      <div className="content">
        {children}
      </div>
    </div>
  );
}

export default UserLayout;
