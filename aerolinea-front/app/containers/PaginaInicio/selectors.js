import { createSelector } from 'reselect';

/**
 * Direct selector to the paginaInicio state domain
 */
const selectPaginaInicioDomain = (state) => state.get('paginaInicio');

/**
 * Other specific selectors
 */


/**
 * Default selector used by PaginaInicio
 */

const makeSelectPaginaInicio = () => createSelector(
  selectPaginaInicioDomain,
  (substate) => substate.toJS()
);

export default makeSelectPaginaInicio;
export {
  selectPaginaInicioDomain,
};
