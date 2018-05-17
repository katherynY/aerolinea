/*
 *
 * ConsultarReservas reducer
 *
 */

import { fromJS } from 'immutable';
import {
  DEFAULT_ACTION,
} from './constants';

const initialState = fromJS({
  reservas: false,
});

function consultarReservasReducer(state = initialState, action) {
  switch (action.type) {
    case 'GUARDAR_RESPUESTA':
      return state.set('reservas', action.value);
    case 'GUARDAR_CEDULA':
      return state.set('cedula', action.value);
    default:
      return state;
  }
}

export default consultarReservasReducer;
