import React, { useState, useEffect } from 'react';
import Header from './layout/Header';
import Sidebar from './layout/Sidebar';
import EmailList from './page/EmailList';
import EmailView from './page/EmailView';
import EmailCompose from './page/EmailCompose';


function App() {
  const [emails, setEmails] = useState([]);
  const [selectedEmail, setSelectedEmail] = useState(null);
  const [composeOpen, setComposeOpen] = useState(false);

  useEffect(() => {
    // Fetch emails from API or data source here
    // For the demo, we'll just use hardcoded data
    const dummyEmails = [
      { id: 1, sender: 'John Doe', subject: 'Hello there', date: '2022-06-15', content: 'Welcome to our mail client' },
      { id: 2, sender: 'Jane Doe', subject: 'RE: Hello there', date: '2022-06-16', content: 'Thanks for your email!' },
    ];
    setEmails(dummyEmails);
  }, []);
    
  const handleSelectEmail = (email) => {
    setSelectedEmail(email);
  };

  const handleComposeToggle = () => {
    setComposeOpen(!composeOpen);
  };

  return (
    <div className="app">
      <Header onComposeClick={handleComposeToggle} />
      <div className="app-body">
        <Sidebar />
        <EmailList emails={emails} onSelectEmail={handleSelectEmail} />
        {selectedEmail && <EmailView email={selectedEmail} />}
      </div>
      {composeOpen && <EmailCompose onClose={handleComposeToggle} />}
    </div>
  );
}

export default App;