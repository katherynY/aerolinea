
import { fromJS } from 'immutable';
import consultarReservasReducer from '../reducer';

describe('consultarReservasReducer', () => {
  it('returns the initial state', () => {
    expect(consultarReservasReducer(undefined, {})).toEqual(fromJS({}));
  });
});
