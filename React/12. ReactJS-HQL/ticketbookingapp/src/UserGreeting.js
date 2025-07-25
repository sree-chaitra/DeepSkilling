import React from 'react';

function UserGreeting() {
  return (
    <div>
      <h2>Welcome Back, User!</h2>
      <p>You can now book your flight tickets.</p>
      <ul>
        <li>Flight 1: Bangalore → Delhi - ₹3,200</li>
        <li>Flight 2: Mumbai → Chennai - ₹2,800</li>
        <li>Flight 3: Hyderabad → Kolkata - ₹3,500</li>
      </ul>
      <button>Book Now</button>
    </div>
  );
}

export default UserGreeting;
