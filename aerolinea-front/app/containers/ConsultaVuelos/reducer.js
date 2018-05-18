/*
 *
 * ConsultaVuelos reducer
 *
 */

import { fromJS } from 'immutable';
import {
  DEFAULT_ACTION,
} from './constants';

const initialState = fromJS({
  vuelos: false,
  detalleVuelo: {
    horaOrigen: 'Seleccione un vuelo ', ciudadOrigen: 'Seleccione un vuelo ',
  },
  valor: 'Seleccione un vuelo ',
});

function consultaVuelosReducer(state = initialState, action) {
  switch (action.type) {
    case 'GUARDAR_RESPUESTA':
      return state.set('vuelos', action.value);
    case 'GUARDAR_ELEMENTOS':
      return state.set('detalleVuelo', action.value);
    case 'GUARDAR_VALOR':
      return state.set('valor', action.value);
    default:
      return state;
  }
}

export default consultaVuelosReducer;
