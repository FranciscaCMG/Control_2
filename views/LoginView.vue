<template>
  <div class="container">
    <div class="row">
      <h1 class="text-center">Login</h1>
      <div class="class= col-lg-4 col-md-6 col-sm-12 mx-auto">
        <div class="card-body">
          <div class="wrapper fadeInDown">
            <div>
              <form v-on:submit.prevent="login" method="post">
                <input type="text" id="email" class="form-control" name="email" placeholder="Email" v-model="user.email">
                <input type="text" id="pass" class="form-control" name="pass" placeholder="Contraseña" v-model="user.pass">
                <input type="submit" class="btn btn-success" value="Iniciar Sesion">
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
  name: 'LoginView',
  data() {
    return {
      user : {
        email : '',
        pass : '',
      },
    }
  },
  methods: {
    login() {
      const userData = {
        "email" : this.email,
        "pass" : this.pass
      };

      axios.post('http://localhost:8086/login', userData)
  .then(response => {
    this.$router.push('/tareas')
    // Si el inicio de sesión es exitoso, response.data podría contener información del usuario
    console.log(response.data);

    // Guardar la cookie en una variable o en localStorage para su uso posterior
    const cookie = document.cookie;
      
    // Guardar la cookie en localStorage para usarla en otras vistas o funciones
    localStorage.setItem('myCookie', cookie);

    // Redirigir a la siguiente vista o realizar otras acciones después del inicio de sesión
    window.location.href = 'tareas';
  })
  .catch(error => {
    // En caso de error, mostrar un mensaje de error de credenciales
    console.error('Error de credenciales:', error);
  });



    }
  }
};
</script>