import React, { useState } from 'react';
import CurrencyConverter from './CurrencyConverter';

function App() {
  const [count, setCount] = useState(0);

  const incrementValue = () => {
    setCount(prev => prev + 1);
    sayHello();
  };

  const sayHello = () => {
    alert('Hello! You just increased the count.');
  };

  const decrementValue = () => {
    setCount(prev => prev - 1);
    sayGoodbye();
  };

  const sayGoodbye = () => {
    alert('You just decreased the count.');
  };

  const sayWelcome = () => {
    alert('Welcome!');
  };

  const handleClick = () => {
    alert('I was clicked!!');
  };

  return (
    <div style={{ fontFamily: 'Arial', padding: '30px' }}>
      <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: '30px' }}>
        <div
          style={{
            backgroundColor: '#f8b195',
            padding: '30px',
            flex: 1,
            marginRight: '10px',
            textAlign: 'center',
            borderRadius: '10px'
          }}
        >
          <button onClick={incrementValue}>Increment</button>
        </div>

        <div
          style={{
            backgroundColor: '#f67280',
            padding: '30px',
            flex: 1,
            marginRight: '10px',
            textAlign: 'center',
            borderRadius: '10px'
          }}
        >
          <button onClick={decrementValue}>Decrement</button>
        </div>

        <div
          style={{
            backgroundColor: '#c06c84',
            padding: '30px',
            flex: 1,
            marginRight: '10px',
            textAlign: 'center',
            borderRadius: '10px'
          }}
        >
          <button onClick={sayWelcome}>Say Welcome</button>
        </div>

        <div
          style={{
            backgroundColor: '#6c5b7b',
            padding: '30px',
            flex: 1,
            textAlign: 'center',
            borderRadius: '10px',
            color: '#fff'
          }}
        >
          <button onClick={handleClick}>Click on me</button>
        </div>
      </div>

      <h2 style={{ color: 'green', textAlign: 'center', marginBottom: '20px' }}>Currency Converter!!</h2>

      <CurrencyConverter />
    </div>
  );
}

export default App;
