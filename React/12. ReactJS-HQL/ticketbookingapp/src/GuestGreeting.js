import React from 'react';

function GuestGreeting() {
  return (
    <div>
      <h2>Welcome, Guest!</h2>
      <p>Please log in to book your tickets. Meanwhile, here are some flights you can explore:</p>
      <ul>
        <li>Flight 1: Bangalore → Delhi</li>
        <li>Flight 2: Mumbai → Chennai</li>
        <li>Flight 3: Hyderabad → Kolkata</li>
      </ul>
    </div>
  );
}

export default GuestGreeting;
