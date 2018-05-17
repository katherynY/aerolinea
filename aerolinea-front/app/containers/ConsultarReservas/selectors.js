import { createSelector } from 'reselect';

/**
 * Direct selector to the consultarReservas state domain
 */
const selectConsultarReservasDomain = (state) => state.get('consultarReservas');

/**
 * Other specific selectors
 */


/**
 * Default selector used by ConsultarReservas
 */

const makeSelectConsultarReservas = () => createSelector(
  selectConsultarReservasDomain,
  (substate) => substate.toJS()
);

export default makeSelectConsultarReservas;
export {
  selectConsultarReservasDomain,
};
