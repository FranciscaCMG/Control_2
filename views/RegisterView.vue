<template>
  <div class="container">
    <div class="row">
      <h1 class="text-center">Registro de Usuario</h1>
      <div class="class= col-lg-4 col-md-6 col-sm-12 mx-auto">
        <div class="card-body">
          <div class="wrapper fadeInDown">
            <div id="formContent">
              <!-- Tabs Titles -->
              <!-- Icon -->
              <!-- Login Form -->
              <form v-on:submit.prevent="register" method="post">
                <input type="text" id="rut" class="form-control" name="rut" placeholder="Rut" v-model="nuevoUsuario.rut">
                <input type="text" id="nombres" class="form-control" name="nombres" placeholder="Nombres"
                  v-model="nuevoUsuario.nombres">
                <input type="text" id="apellidos" class="form-control" name="apellidos" placeholder="Apellidos"
                  v-model="nuevoUsuario.apellidos">
                <input type="text" id="email" class="form-control" name="correo" placeholder="Correo"
                  v-model="nuevoUsuario.email">
                <input type="text" id="password" class="form-control" name="contraseña" placeholder="Contraseña"
                  v-model="nuevoUsuario.pass">
                <input type="submit" class = "btn btn-success" value="Enviar">
              </form>
            </div>
          </div>
        </div>
      </div>
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
      axios.post("http://localhost:8086/register", {
        "rut": this.nuevoUsuario.rut,
        "nombres": this.nuevoUsuario.nombres,
        "apellidos": this.nuevoUsuario.apellidos,
        "email": this.nuevoUsuario.email,
        "pass": this.nuevoUsuario.pass
        
      }),
      this.$router.push('/login')
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