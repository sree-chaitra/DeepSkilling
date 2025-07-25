import React from 'react';
import './App.css';
import officeImg from './office.jpg'; // Place office.jpg in /src folder

function App() {
  const heading = "Office Space";
  const jsxatt = <img src={officeImg} height="300px" alt="Office Space" />;

  const offices = [
    { Name: "DBS", Rent: 50000, Address: "Chennai" },
    { Name: "WeWork", Rent: 70000, Address: "Bangalore" },
    { Name: "Regus", Rent: 45000, Address: "Hyderabad" },
    { Name: "Awfis", Rent: 85000, Address: "Mumbai" }
  ];

  return (
    <div className="App">
      <h1>{heading} at Affordable Range</h1>
      {jsxatt}

      {offices.map((item, index) => (
        <div key={index} className="office-card">
          <h2>Name: {item.Name}</h2>
          <h3 className={item.Rent <= 60000 ? 'text-red' : 'text-green'}>
            Rent: Rs. {item.Rent}
          </h3>
          <p>Address: {item.Address}</p>
        </div>
      ))}
    </div>
  );
}

export default App;
