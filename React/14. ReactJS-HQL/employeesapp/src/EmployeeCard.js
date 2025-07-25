// src/EmployeeCard.js
import React, { useContext } from 'react';
import ThemeContext from './ThemeContext';

function EmployeeCard({ employee }) {
  const theme = useContext(ThemeContext); // Get theme from context

  return (
    <div style={{ border: '1px solid #ccc', padding: '10px', width: '200px' }}>
      <h3>{employee.name}</h3>
      <p>{employee.email}</p>
      <p>{employee.mobile}</p>
      <button className={`btn-${theme.toLowerCase()}`}>Edit</button>
      <button className={`btn-${theme.toLowerCase()}`}>Delete</button>
    </div>
  );
}

export default EmployeeCard;
