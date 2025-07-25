// src/App.js
import React, { useState } from 'react';
import EmployeesList from './EmployeesList';
import ThemeContext from './ThemeContext';

function App() {
  const [theme, setTheme] = useState('light');

  const handleThemeChange = (e) => {
    setTheme(e.target.value);
  };

  return (
    <ThemeContext.Provider value={theme}>
      <div>
        <label>SELECT A THEME </label>
        <select onChange={handleThemeChange} value={theme}>
          <option>Light</option>
          <option>Dark</option>
        </select>

        <h1>Employees List</h1>
        <EmployeesList /> {/* Theme not passed via props anymore */}
      </div>
    </ThemeContext.Provider>
  );
}

export default App;
