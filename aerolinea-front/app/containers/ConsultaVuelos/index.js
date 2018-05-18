/**
 *
 * ConsultaVuelos
 *
 */

import React from 'react';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import { createStructuredSelector } from 'reselect';
import { compose } from 'redux';
import {
  Modal,
  ModalHeader,
  ModalTitle,
  ModalClose,
  ModalBody,
  ModalFooter,
} from 'react-modal-bootstrap';
import axios from 'axios';
import * as constants from './constants'

import injectSaga from 'utils/injectSaga';
import injectReducer from 'utils/injectReducer';
import makeSelectConsultaVuelos from './selectors';
import reducer from './reducer';
import saga from './saga';

export class ConsultaVuelos extends React.Component { // eslint-disable-line react/prefer-stateless-function

  state = {
    isOpen: false,
  };

  componentDidMount() {
    this.props.consultarVuelos();
  }

  openModal = () => {
    this.setState({
      isOpen: true,
    });
  };

  hideModal = () => {
    this.setState({
      isOpen: false,
    });
  };

  openSubModal = () => {
    this.setState({
      isSubOpen: true,
    });
  };

  hideSubModal = () => {
    this.setState({
      isSubOpen: false,
    });
  };

  cargarInformacion = (vuelo) => {
    this.props.guardarElementos(vuelo);
    const body = {
      cedula: '1214714036',
      vuelos: { ...this.props.consultavuelos.detalleVuelo },
    };
    console.log(body);
  }

  guardarValores = (valor, tipoValor) => {
    var valores = valor + ' - ' + tipoValor;
    this.props.guardarValor(valores);
  }

  finalizaReserva = () => {
    this.setState({
      isOpen: false,
    });
  };

  render() {
    const listaVuelos = this.props.consultavuelos.vuelos
      && this.props.consultavuelos.vuelos.map((item) => (
        <tr key={item.idVuelo} onClick={() => this.cargarInformacion(item)}>
          <td>{item.horaOrigen} - {item.ciudadOrigen}</td>
          <td className="texto-valores">$ {item.superpromoSTRING}
            <input value={item.superpromoSTRING} type="radio" onClick={() => this.guardarValores(item.superpromoSTRING, constants.VALOR_SUPER_PROMO)} name="valor"></input>
          </td>
          <td className="texto-valores">$ {item.economicaSTRING}
            <input value={item.economicaSTRING} type="radio" onClick={() => this.guardarValores(item.economicaSTRING, constants.DEFAULT_ECONOMICA)} name="valor"></input>
          </td>
          <td className="texto-valores">$ {item.ejecutivoSTRING}
            <input value={item.ejecutivoSTRING} type="radio" onClick={() => this.guardarValores(item.ejecutivoSTRING, constants.DEFAULT_EJECUTIVO)} name="valor"></input>
          </td>
          <td className="texto-valores">$ {item.primeraClaseSTRING}
            <input value={item.primeraClaseSTRING} type="radio" onClick={() => this.guardarValores(item.primeraClaseSTRING, constants.DEFAULT_PRIMERA_CLASE)} name="valor"></input>
          </td>
        </tr>
      ));

    return (
      <div>
        {
          listaVuelos.length !== 0 ?
            <div>
              <div className="container-fluid sectionContainer no-pad">
                <div className="col-xs-12 col-sm-10 col-md-9 no-pad">
                  <div className="sectionContainer-gral">
                    <div className="form-horizontal">
                      <div className="form-group">
                        <div className="col-md-12">
                          <h2>Vuelos de Ida:</h2>
                        </div>
                      </div>
                      <div className="form-group">
                        <div className="col-md-12">
                          <div className="table-responsive">
                            <table className="table table-hover ">
                              <thead>
                                <tr>
                                  <th >Hora de Ida</th>
                                  <th className="texto-valores">Superpromo</th>
                                  <th className="texto-valores">Economica</th>
                                  <th className="texto-valores">Ejecutivo</th>
                                  <th className="texto-valores">Primera clase</th>
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
                          <label>{this.props.consultavuelos.detalleVuelo.horaOrigen} - {this.props.consultavuelos.detalleVuelo.ciudadOrigen} </label>
                        </div>
                      </div>
                      <div className="form-group">
                        <div className="col-md-12">
                          <label>VALOR</label>
                          <label> $ {this.props.consultavuelos.valor} </label>
                        </div>
                      </div>
                      <div className="form-group">
                        <div className="col-md-12">
                          <button type="button" className="search" onClick={this.openModal}>Continuar</button>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <Modal isOpen={this.state.isOpen} size='modal-lg' onRequestHide={this.hideModal}>
                  <ModalHeader>
                    <ModalClose onClick={this.hideModal} />
                    <ModalTitle> Confirmar reserva de vuelo número aaa8972</ModalTitle>
                  </ModalHeader>
                  <ModalBody>
                    <div className="form-horizontal">
                      <div className="form-group block-labels">
                        <div className="col-md-4">
                          <label>Fecha de Reserva</label>
                          <label>{}</label>
                        </div>
                        <div className="col-md-4">
                          <label>Vuelo ida </label>
                          <label>{this.props.consultavuelos.detalleVuelo.fechaIdaSTRING} - {this.props.consultavuelos.detalleVuelo.ciudadOrigen} </label>
                          <label></label>
                        </div>
                      </div>
                      <div className="form-group block-labels">
                        <div className="col-md-4">
                          <label>Clase Ejecutivo</label>
                        </div>
                        <div className="col-md-4">
                          <label>Valor</label>
                          <label>$ {this.props.consultavuelos.valor} </label>
                        </div>
                      </div>
                      <hr></hr>
                      <div className="form-group block-labels">
                        <h2>Datos de quien reserva</h2>
                      </div>
                      <div className="form-group block-labels">
                        <div className="col-md-6">
                          <label>Nombre</label>
                          <input type="text" className="form-control" />
                        </div>
                        <div className="col-md-6">
                          <label>Apellido</label>
                          <input type="text" className="form-control" />
                        </div>
                      </div>
                    </div>
                  </ModalBody>
                  <ModalFooter>
                    <button className='btn btn-default' onClick={this.hideModal}>
                      Cerrar
              </button>
                    <button className='btn btn-primary' onClick={this.hideModal}>
                      Reservar
              </button>
                  </ModalFooter>
                </Modal>
              </div>
            </div>
            : <div>
              <div className="container-fluid sectionContainer no-pad">
                <div className="col-xs-12 col-sm-10 col-md-9 no-pad">
                  <div className="sectionContainer-gral">
                    <div className="form-horizontal">
                      <div className="form-group container-no-data">
                        <div className="col-md-12 text-center">
                          <br />
                          <br />
                          <br />
                          <br />
                          <br />
                          <br />
                          <h1 className="sin-datos" >No hay vuelos disponibles</h1>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
        }
      </div >
    );
  }
}
ConsultaVuelos.propTypes = {
  consultarVuelos: PropTypes.func,
  guardarElementos: PropTypes.func,
  guardarValor: PropTypes.func,
  consultavuelos: PropTypes.object,
};

const mapStateToProps = createStructuredSelector({
  consultavuelos: makeSelectConsultaVuelos(),
});

function mapDispatchToProps(dispatch) {
  return {
    guardarElementos: (value) => { dispatch({ type: 'GUARDAR_ELEMENTOS', value }); },
    guardarValor: (value) => { dispatch({ type: 'GUARDAR_VALOR', value }); },
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

// function run() {
//   ReactDOM.render(< App />, document.getElementById('app'));
// }

// if (window.addEventListener) {
//   window.addEventListener('DOMContentLoaded', run);
// } else {
//   window.attachEvent('onload', run);
// }
