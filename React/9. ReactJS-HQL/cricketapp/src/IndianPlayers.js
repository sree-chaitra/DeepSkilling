import React from 'react';

export function OddPlayers({ team }) {
  const [first, , third, , fifth] = team;
  return (
    <ul style={{ textAlign: 'left' }}>
      <li>First: {first}</li>
      <li>Third: {third}</li>
      <li>Fifth: {fifth}</li>
    </ul>
  );
}

export function EvenPlayers({ team }) {
  const [, second, , fourth, , sixth] = team;
  return (
    <ul style={{ textAlign: 'left' }}>
      <li>Second: {second}</li>
      <li>Fourth: {fourth}</li>
      <li>Sixth: {sixth}</li>
    </ul>
  );
}
