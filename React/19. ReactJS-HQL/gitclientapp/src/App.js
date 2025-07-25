// src/App.js
import React, { useEffect, useState } from 'react';
import GitClient from './GitClient';

function App() {
  const [repos, setRepos] = useState([]);

  useEffect(() => {
    GitClient.getRepositories('techiesyed').then(setRepos);
  }, []);

  return (
    <div className="App">
      <h1>Repositories for techiesyed</h1>
      <ul>
        {repos.map(repo => <li key={repo}>{repo}</li>)}
      </ul>
    </div>
  );
}

export default App;
