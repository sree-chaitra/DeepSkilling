import React from 'react';
import './CountPeople.css';

class CountPeople extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      entrycount: 0,
      exitcount: 0
    };

    this.updateEntry = this.updateEntry.bind(this);
    this.updateExit = this.updateExit.bind(this);
  }

  updateEntry() {
    this.setState((prevState) => ({
      entrycount: prevState.entrycount + 1
    }));
  }

  updateExit() {
    this.setState((prevState) => ({
      exitcount: prevState.exitcount + 1
    }));
  }

  render() {
    return (
      <div className="container">
        <div className="box login-box">
          <button onClick={this.updateEntry}>Login</button>
          <p>{this.state.entrycount} People Entered!</p>
        </div>

        <div className="box exit-box">
          <button onClick={this.updateExit}>Exit</button>
          <p>{this.state.exitcount} People Left!</p>
        </div>
      </div>
    );
  }
}

export default CountPeople;
