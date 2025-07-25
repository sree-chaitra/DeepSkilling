import React, { useState } from 'react';
import Greeting from './Greeting';
import LoginButton from './LoginButton';
import LogoutButton from './LogoutButton';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLoginClick = () => {
    setIsLoggedIn(true);
  };

  const handleLogoutClick = () => {
    setIsLoggedIn(false);
  };

  return (
    <div style={{ padding: '30px', fontFamily: 'Arial' }}>
      <h1>Flight Booking Portal</h1>
      <Greeting isLoggedIn={isLoggedIn} />
      <div style={{ marginTop: '20px' }}>
        {isLoggedIn ? (
          <LogoutButton onClick={handleLogoutClick} />
        ) : (
          <LoginButton onClick={handleLoginClick} />
        )}
      </div>
    </div>
  );
}

export default App;
