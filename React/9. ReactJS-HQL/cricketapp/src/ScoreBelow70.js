import React from 'react';

function ScoreBelow70({ players }) {
  const below70 = players.filter(player => player.score < 70);

  return (
    <ul>
      {below70.map((item, index) => (
        <li key={index}>
          Mr. {item.name} - <strong>{item.score}</strong>
        </li>
      ))}
    </ul>
  );
}

export default ScoreBelow70;
