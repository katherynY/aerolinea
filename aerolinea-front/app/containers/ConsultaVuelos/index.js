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
import axios from 'axios';


export class ConsultaVuelos extends React.Component { // eslint-disable-line react/prefer-stateless-function

  componentDidMount() {
    this.props.consultarVuelos();
  }

  render() {
    const listaVuelos = this.props.consultavuelos.vuelos
      && this.props.consultavuelos.vuelos.map((item) => (
        <tr key={item.idVuelo}>
          <td>{item.horaOrigen} - {item.ciudadOrigen}
            <br /> {item.horaDestino} - {item.ciudadDestino} </td>
          <td >$ {item.superpromoSTRING}</td>
          <td >$ {item.economicaSTRING}</td>
          <td >$ {item.ejecutivoSTRING}</td>
          <td>$ {item.primeraClaseSTRING}</td>
        </tr>

      ));
    return (
      <div className="container-fluid sectionContainer no-pad" >
        <div className="col-xs-12 col-sm-10 col-md-9 no-pad">
          <div className="sectionContainer-gral">
            <div className="form-horizontal">
              <div className="form-group">
                <div className="col-md-12">
                  <h2>Resultados de los vuelos para:</h2>
                </div>
              </div>
              <div className="form-group">
                <div className="col-md-12">
                  <div className="table-responsive">
                    <table className="table table-hover ">
                      <thead>
                        <tr>
                          <th>Hora</th>
                          <th>Superpromo</th>
                          <th>Economica</th>
                          <th>Ejecutivo</th>
                          <th>Primera clase</th>
                        </tr>
                      </thead>
                      <tbody>
                        {listaVuelos}
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
            <div className="form-horizontal">
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
                  <button className="search">Continuar</button>
                </div>
              </div>
              <div className="form-group">
                <div className="col-md-12">
                  <a href="./ConsultaVuelos/">Realizar otra búsqueda</a>
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
  consultarVuelos: PropTypes.func,
  consultavuelos: PropTypes.object,
};

const mapStateToProps = createStructuredSelector({
  consultavuelos: makeSelectConsultaVuelos(),
});

function mapDispatchToProps(dispatch) {
  return {
    consultarVuelos: () => {
      axios.get('http://localhost:8085/vuelos/consultar')
        .then((response) => {
          dispatch({ type: 'GUARDAR_RESPUESTA', value: response.data });
        })
        .catch((error) => {
          alert(error);
        });
    },
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
