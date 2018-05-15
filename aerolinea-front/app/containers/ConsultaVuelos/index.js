/**
 *
 * ConsultaVuelos
 *
 */

import React from 'react';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import { Helmet } from 'react-helmet';
import { FormattedMessage } from 'react-intl';
import { createStructuredSelector } from 'reselect';
import { compose } from 'redux';

import injectSaga from 'utils/injectSaga';
import injectReducer from 'utils/injectReducer';
import makeSelectConsultaVuelos from './selectors';
import reducer from './reducer';
import saga from './saga';
import messages from './messages';

export class ConsultaVuelos extends React.Component { // eslint-disable-line react/prefer-stateless-function
  render() {
    return (
      <div className="container-fluid sectionContainer no-pad">
          <div className="col-xs-12 col-sm-10 col-md-9 no-pad">
            <div className="sectionContainer-gral">
              <div className="form-horizontal">
                <div className="form-group">
                  <div className="col-md-12">
                    <h2>Resultados de los vuelos para:</h2>
                  </div>
                </div>
                <div className="form-group">
                  <div className="col-sm-4 col-xs-12 col-md-4">
                    <div className="boxInfo">
                      <label>Medellin</label>
                      <label>-</label>
                      <label>Cali</label>
                    </div>
                  </div>
                  <div className="col-sm-4 col-xs-12 col-md-4">
                    <div className="boxInfo">
                      <label>Medellin</label>
                      <label>-</label>
                      <label>Cali</label>
                    </div>
                  </div>
                  <div className="col-sm-4 col-xs-12 col-md-4">
                    <div className="boxInfo">
                      <label>Medellin</label>
                      <label>-</label>
                      <label>Cali</label>
                    </div>
                  </div>
                </div>
                <div className="form-group">
                  <div className="col-md-12">
                    <div className="table-responsive">
                      <table className="table table-hover ">
                          <thead>
                              <tr>
                                  <th>Row</th>
                                  <th>First Name</th>
                                  <th>Last Name</th>
                                  <th>Email</th>
                              </tr>
                          </thead>
                          <tbody>
                              <tr>
                                  <td>1</td>
                                  <td>John</td>
                                  <td>Carter</td>
                                  <td>johncarter@mail.com</td>
                              </tr>
                              <tr>
                                  <td>2</td>
                                  <td>Peter</td>
                                  <td>Parker</td>
                                  <td>peterparker@mail.com</td>
                              </tr>
                              <tr>
                                  <td>3</td>
                                  <td>John</td>
                                  <td>Rambo</td>
                                  <td>johnrambo@mail.com</td>
                              </tr>
                          </tbody>
                      </table>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div className="col-xs-12 col-sm-10 col-md-3 no-pad">
          <div className="infoLateral">
            <div class="form-horizontal">
              <div className="form-group">
                <div className="col-md-12">
                  <h2>Tu selección</h2>
                </div>
              </div>
              <div className="form-group">
                <div className="col-md-12">
                  <label>IDA</label>
                  <label>10:00 am - Medellin</label>
                </div>
              </div>
              <div className="form-group">
                <div className="col-md-12">
                  <label>Regreso</label>
                  <label>10:00 am - Cali</label>
                </div>
              </div>
              <div className="form-group">
                <div className="col-md-12">
                  <hr></hr>
                </div>
              </div>
              <div className="form-group">
                <div className="col-md-12">
                  <label>VALOR</label>
                  <label>$ 450.000</label>
                </div>
              </div>
              <div className="form-group">
                <div className="col-md-12">
                  <button  className="search">Continuar</button>
                </div>
              </div>
              <div className="form-group">
                <div className="col-md-12">
                  <a href="#">Realizar otra búsqueda</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

ConsultaVuelos.propTypes = {
  dispatch: PropTypes.func.isRequired,
};

const mapStateToProps = createStructuredSelector({
  consultavuelos: makeSelectConsultaVuelos(),
});

function mapDispatchToProps(dispatch) {
  return {
    dispatch,
  };
}

const withConnect = connect(mapStateToProps, mapDispatchToProps);

const withReducer = injectReducer({ key: 'consultaVuelos', reducer });
const withSaga = injectSaga({ key: 'consultaVuelos', saga });

export default compose(
  withReducer,
  withSaga,
  withConnect,
)(ConsultaVuelos);
