import React, { useState } from 'react';
import { Button, Form, FormGroup, Label, Input } from 'react';
//import { Link } from 'react-dom';
//import './styles/Login.scss';

export default function SingIn() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  function handleSubmit(event) {
    event.preventDefault();
    // Обработка данных формы
  }

  return (
    <div className="login-container">
      <h2>Вход в почту</h2>
      <Form onSubmit={handleSubmit}>
        <FormGroup>
          <Label for="email">Email</Label>
          <Input
            type="email"
            name="email"
            id="email"
            placeholder="Введите email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </FormGroup>
        <FormGroup>
          <Label for="password">Пароль</Label>
          <Input
            type="password"
            name="password"
            id="password"
            placeholder="Введите пароль"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
        </FormGroup>
        <Button color="primary" type="submit">
          Войти
        </Button>
      </Form>
      
    </div>
  );
}
