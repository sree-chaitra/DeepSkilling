import React, { useState } from 'react';
import ListofPlayers from './ListofPlayers';
import ScoreBelow70 from './ScoreBelow70';
import { OddPlayers, EvenPlayers } from './IndianPlayers';
import ListofIndianPlayers from './ListofIndianPlayers';
import './App.css';

function App() {
  const [showIndianPlayers, setShowIndianPlayers] = useState(false); // Toggle state

  const players = [
    { name: 'Jack', score: 50 },
    { name: 'Michael', score: 70 },
    { name: 'John', score: 40 },
    { name: 'Ann', score: 61 },
    { name: 'Elisabeth', score: 61 },
    { name: 'David', score: 95 },
    { name: 'Steve', score: 100 },
    { name: 'Virat', score: 84 },
    { name: 'Jadeja', score: 64 },
    { name: 'Raina', score: 75 },
    { name: 'Rohit', score: 80 },
  ];

  const IndianTeam = ['Sachin', 'Dhoni', 'Virat', 'Rohit', 'Yuvaraj', 'Raina'];
  const IndianPlayers = ['First Player', 'Second Player', 'Third Player'];
  const RanjiTrophyPlayers = ['Fourth Player', 'Fifth Player', 'Sixth Player'];

  return (
    <div className="App">
      <button
        className="toggle-btn"
        onClick={() => setShowIndianPlayers(!showIndianPlayers)}
      >
        {showIndianPlayers ? 'Show Scoreboard' : 'Show Indian Team'}
      </button>

      {showIndianPlayers ? (
        <>
          <h1>Indian Team</h1>

          <h2>Odd Players</h2>
          <div className="box"><OddPlayers team={IndianTeam} /></div>

          <h2>Even Players</h2>
          <div className="box"><EvenPlayers team={IndianTeam} /></div>

          <h2>List of Indian Players Merged:</h2>
          <div className="box">
            <ListofIndianPlayers players={[...IndianPlayers, ...RanjiTrophyPlayers]} />
          </div>
        </>
      ) : (
        <>
          <h1>List of Players</h1>
          <div className="box"><ListofPlayers players={players} /></div>

          <h1>List of Players having Scores Less than 70</h1>
          <div className="box"><ScoreBelow70 players={players} /></div>
        </>
      )}
    </div>
  );
}

export default App;
