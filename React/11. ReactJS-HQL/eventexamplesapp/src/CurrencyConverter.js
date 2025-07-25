import React, { useState } from 'react';

function CurrencyConverter() {
  const [rupees, setRupees] = useState('');
  const [currency, setCurrency] = useState('');
  const [result, setResult] = useState('');

 const handleSubmit = () => {
  if (currency.toLowerCase() === 'euro') {
    const conversionRate = 0.011;
    const converted = (parseFloat(rupees) * conversionRate).toFixed(2);
    alert(`Converting to Euro. ₹${rupees} = €${converted}`);
    setResult(`€${converted}`);
  } else {
    alert('Currently, only conversion to Euro is supported.');
    setResult('');
  }
};


  return (
    <div
      style={{
        border: '2px solid #ccc',
        padding: '20px',
        width: '300px',
        margin: '0 auto',
        borderRadius: '10px',
        backgroundColor: '#f0f0f0',
        textAlign: 'left',
      }}
    >
      <div style={{ marginBottom: '10px' }}>
        <label><strong>Amount</strong></label><br />
        <input
          type="number"
          placeholder="Enter amount in ₹"
          value={rupees}
          onChange={(e) => setRupees(e.target.value)}
          style={{ width: '100%', padding: '8px', marginTop: '5px' }}
        />
      </div>

      <div style={{ marginBottom: '10px' }}>
        <label><strong>Currency</strong></label><br />
        <input
          type="text"
          placeholder="Enter currency (e.g., Euro)"
          value={currency}
          onChange={(e) => setCurrency(e.target.value)}
          style={{
            width: '100%',
            padding: '8px',
            marginTop: '5px',
            border: '1px solid #ccc',
          }}
        />
      </div>

      <button
        onClick={handleSubmit}
        style={{
          padding: '10px',
          width: '100%',
          backgroundColor: '#4CAF50',
          color: 'white',
          border: 'none',
          borderRadius: '5px',
        }}
      >
        Convert
      </button>

      {result && (
        <p style={{ marginTop: '15px' }}>
          Equivalent in Euros: <strong>{result}</strong>
        </p>
      )}
    </div>
  );
}

export default CurrencyConverter;
