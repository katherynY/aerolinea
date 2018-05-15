
import { fromJS } from 'immutable';
import consultaVuelosReducer from '../reducer';

describe('consultaVuelosReducer', () => {
  it('returns the initial state', () => {
    expect(consultaVuelosReducer(undefined, {})).toEqual(fromJS({}));
  });
});
