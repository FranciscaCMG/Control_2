<template>
  <div class="wrapper fadeInDown">
    <div id="formContent">
      <!-- Tabs Titles -->
      <!-- Icon -->
      <!-- Login Form -->
      <form v-on:submit.right="register">
        <input type="text" id="rut" class="fadeIn second" name="login" placeholder="Rut" v-model="rut">
        <input type="text" id="nombres" class="fadeIn second" name="login" placeholder="Nombres" v-model="nombres">
        <input type="text" id="apellidos" class="fadeIn second" name="login" placeholder="Apellidos" v-model="apellidos">
        <input type="text" id="email" class="fadeIn second" name="login" placeholder="Correo" v-model="email">
        <input type="text" id="password" class="fadeIn third" name="login" placeholder="Contraseña" v-model="pass">
        <input type="submit" class="fadeIn fourth" value="Enviar">
      </form>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'RegisterView',
  data() {
    return {
      nuevoUsuario: {
        rut: '',
        nombres: '',
        apellidos: '',
        email: '',
        pass: '',
      },
    }
  },
  methods: {
    register() {
      let json = {
      "rut" : this.rut,
      "nombres" : this.nombres,
      "apellidos" : this.apellidos,
      "email" : this.email,
      "pass" : this.pass
      };
      axios.post("http://localhost:8086/usuario", json)
        .then(response => {
          console.log(response.data);
        })
        .catch(error => {
          console.error(error);
        });
    }
  }
}

</script>

<style>
</style>
