<template>
    <div class="container">
      <h1 class="text-center">Tus Tareas</h1>
      <button class="btn btn-primary" @click="crearTarea()">Nueva Tarea</button>
      <br>
      <br>
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
              <button class="btn btn-warning" @click="editarTarea(tarea)">Editar</button>
              <button class="btn btn-danger" @click="eliminarTarea(tarea.id_tarea)">Eliminar</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </template>
  
  <script>
  import TareasServices from '../services/TareasServices';
  import axios from 'axios';

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
      eliminarTarea(idTarea) {
    const confirmacion = window.confirm("¿Estás seguro de que deseas eliminar esta tarea?");
    if (!confirmacion) {
      return; // No hacer nada si el usuario cancela la eliminación
    }

    this.eliminandoTarea = true; // Activa el estado de carga

    axios.delete(`http://localhost:8086/delete-tarea/${idTarea}`)
      .then(response => {
        console.log("Tarea eliminada con éxito:", response.data);
        // Actualizar la lista de tareas después de eliminar
        this.getTareas();
      })
      .catch(error => {
        console.error("Error al eliminar la tarea:", error);
        // Podrías mostrar un mensaje de error al usuario aquí si lo deseas
      })
      .finally(() => {
        this.eliminandoTarea = false; // Desactiva el estado de carga sin importar si la eliminación fue exitosa o no
      });
    },
    crearTarea(){
      this.$router.push('/tarea');
    },
    },
    created() {
      this.getTareas();
    },
  };
  </script>