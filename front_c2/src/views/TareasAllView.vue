<template>
    <div class="container">
      <h1 class="text-center">Tus Tareas</h1>
      <table class="table table-striped">
        <thead>
          <th>Titulo</th>
          <th>Descripcion</th>
          <th>Estado</th>
          <th>Prioridad</th>
          <th>Fecha de Creacion</th>
          <th>Fecha de Finalizacion</th>
          <th>Acciones</th>
        </thead>
        <tbody>
          <tr v-for="tarea in tareas" :key="tarea.id_tarea">
            <td>{{ tarea.titulo }}</td>
            <td>{{ tarea.descripcion }}</td>
            <td>{{ tarea.estado }}</td>
            <td>{{ tarea.prioridad }}</td>
            <td>{{ tarea.fechaCreacion }}</td>
            <td>{{ tarea.fechaFin }}</td>
            <td>
              <!-- Botón para editar la tarea -->
              <button @click="editarTarea(tarea)">Editar</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </template>
  
  <script>
  import TareasServices from '../services/TareasServices';

  export default {
    name: 'ListaTareas',
    data() {
      return {
        tareas: [],
      };
    },
    methods: {
      getTareas() {
        TareasServices.getTareas()
          .then((response) => {
            this.tareas = response.data;
          })
          .catch((error) => {
            console.error(error);
          });
      },
      editarTarea(tarea) {
        // Redirige a la página de edición y pasa el ID y los datos de la tarea
        this.$router.push({ name: 'editar-tarea', params: { id: tarea.id_tarea, tarea } });
      },
    },
    created() {
      this.getTareas();
    },
  };
  </script>