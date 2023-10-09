<template>
    <div>
      <input type="email" v-model="email" placeholder="Correo electrónico" />
      <input type="password" v-model="password" placeholder="Contraseña" />
      <button @click="login">Iniciar sesión</button>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        email: '',
        password: ''
      };
    },
    methods: {
      login() {
        const userData = {
          email: this.email,
          password: this.password
        };
  
        axios.post('http://localhost:8086/login', userData)
          .then(response => {
            // Si el inicio de sesión es exitoso, response.data podría contener información del usuario
            console.log(response.data);
  
            // Guardar la cookie en una variable o en localStorage para su uso posterior
            const cookie = document.cookie;
            // Guardar la cookie en localStorage para usarla en otras vistas o funciones
            localStorage.setItem('myCookie', cookie);
  
            // Redirigir a la siguiente vista o realizar otras acciones después del inicio de sesión
          })
          .catch(error => {
            console.error(error);
          });
      }
    }
  };
  </script>