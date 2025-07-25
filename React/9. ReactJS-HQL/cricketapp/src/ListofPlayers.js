import React from 'react';

function ListofPlayers({ players }) {
  return (
    <ul>
      {players.map((item, index) => (
        <li key={index}>
          Mr. {item.name} - <strong>{item.score}</strong>
        </li>
      ))}
    </ul>
  );
}

export default ListofPlayers; 
