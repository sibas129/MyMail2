import React, { useState } from 'react';
import Container from 'react-bootstrap/Container';
import Card from 'react-bootstrap/Card';
import Form from 'react-bootstrap/Form';
import InputGroup from 'react-bootstrap/InputGroup';

function App() {
  const [email, setEmail] = useState('');
  const [subject, setSubject] = useState('');
  const [message, setMessage] = useState('');

  const handleSubmit = (event) => {
    event.preventDefault();

    // Здесь вы можете добавить код для отправки сообщения, например, через API:
    console.log('Email:', email);
    console.log('Subject:', subject);
    console.log('Message:', message);

    setEmail('');
    setSubject('');
    setMessage('');
  };

  return (
    <Container style={{ maxWidth: '800px', marginTop: '50px' }}>
      <Card style={{ padding: '40px' }}>
        <h1>Создать и отправить сообщение</h1>
        <Form onSubmit={handleSubmit}>
          <Form.Group>
            <Form.Label>Email получателя</Form.Label>
            <InputGroup>
              <InputGroup.Prepend>
                <InputGroup.Text>@</InputGroup.Text>
              </InputGroup.Prepend>
              <Form.Control
                type="email"
                placeholder="Введите email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
              />
            </InputGroup>
          </Form.Group>
          <Form.Group>
            <Form.Label>Тема</Form.Label>
            <Form.Control
              type="text"
              placeholder="Введите тему"
              value={subject}
              onChange={(e) => setSubject(e.target.value)}
              required
            />
          </Form.Group>
          <Form.Group>
            <Form.Label>Сообщение</Form.Label>
            <Form.Control
              as="textarea"
              rows={4}
              placeholder="Введите текст сообщения"
              value={message}
              onChange={(e) => setMessage(e.target.value)}
              required
            />
          </Form.Group>
          <Form.Group>
            <Form.Control
              type="submit"
              value="Отправить сообщение"
              className="btn btn-primary"
            />
          </Form.Group>
        </Form>
      </Card>
    </Container>
  );
}

export default App;