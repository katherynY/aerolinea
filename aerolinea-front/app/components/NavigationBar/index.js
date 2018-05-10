/**
*
* NavigationBar
*
*/

import React from 'react';
// import styled from 'styled-components';
import * as ReactBootstrap from 'react-bootstrap';
import { FormattedMessage } from 'react-intl';
import messages from './messages';


class NavigationBar extends React.Component { // eslint-disable-line react/prefer-stateless-function
  render() {
   
    return (

      <div>
        <ReactBootstrap.Navbar collapseOnSelect fixedTop fluid>
          <ReactBootstrap.Navbar.Header>
            <ReactBootstrap.Navbar.Brand>
              <a href="#home">React-Bootstrap</a>
            </ReactBootstrap.Navbar.Brand>
            <ReactBootstrap.Navbar.Toggle/>
          </ReactBootstrap.Navbar.Header>
          <ReactBootstrap.Navbar.Collapse>
            <ReactBootstrap.Nav className="pull-right">
              <ReactBootstrap.NavItem eventKey={1} href="#" >
                Reserva
              </ReactBootstrap.NavItem>
              <ReactBootstrap.NavItem eventKey={2} href="#">
                Promociones
              </ReactBootstrap.NavItem>
              <ReactBootstrap.NavItem eventKey={3} href="#">
                Servicios especiales
              </ReactBootstrap.NavItem>
            </ReactBootstrap.Nav>
          </ReactBootstrap.Navbar.Collapse>
        </ReactBootstrap.Navbar>
      </div>
    );
  }
}

NavigationBar.propTypes = {

};

export default NavigationBar;
