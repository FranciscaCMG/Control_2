<template>
  <div class="wrapper fadeInDown">
    <div id="formContent">
      <!-- Tabs Titles -->
      <!-- Icon -->
      <!-- Login Form -->
      <form v-on:submit.right="register">
        <input type="text" id="rut" class="fadeIn second" name="rut" placeholder="Rut" v-model="nuevoUsuario.rut">
        <input type="text" id="nombres" class="fadeIn second" name="nombres" placeholder="Nombres" v-model="nuevoUsuario.nombres">
        <input type="text" id="apellidos" class="fadeIn second" name="apellidos" placeholder="Apellidos" v-model="nuevoUsuario.apellidos">
        <input type="text" id="email" class="fadeIn second" name="correo" placeholder="Correo" v-model="nuevoUsuario.email">
        <input type="text" id="password" class="fadeIn third" name="contraseña" placeholder="Contraseña" v-model="nuevoUsuario.pass">
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
      
  axios.post("http://localhost:8086/usuario", {
    "rut": this.nuevoUsuario.rut,
    "nombres": this.nuevoUsuario.nombres,
    "apellidos": this.nuevoUsuario.apellidos,
    "email": this.nuevoUsuario.email,
    "pass": this.nuevoUsuario.pass
  })
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

<style></style>
