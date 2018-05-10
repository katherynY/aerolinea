
import { fromJS } from 'immutable';
import paginaInicioReducer from '../reducer';

describe('paginaInicioReducer', () => {
  it('returns the initial state', () => {
    expect(paginaInicioReducer(undefined, {})).toEqual(fromJS({}));
  });
});
