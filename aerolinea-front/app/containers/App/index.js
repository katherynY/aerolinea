/**
 *
 * App
 *
 * This component is the skeleton around the actual pages, and should only
 * contain code that should be seen on all pages. (e.g. navigation bar)
 */

import React from 'react';
import { Helmet } from 'react-helmet';
import styled from 'styled-components';
import { Switch, Route } from 'react-router-dom';

import HomePage from 'containers/HomePage/Loadable';
import ConsultaVuelos from 'containers/ConsultaVuelos/Loadable';
import ConsultarReservas from 'containers/ConsultarReservas/Loadable';
import PaginaInicio from 'containers/PaginaInicio/Loadable';
import FeaturePage from 'containers/FeaturePage/Loadable';
import NotFoundPage from 'containers/NotFoundPage/Loadable';
import Header from 'components/Header';
import Footer from 'components/Footer';
import NavigationBar from '../../components/NavigationBar';
import '!!style-loader!css-loader!../../css/style.css';

const AppWrapper = styled.div`
  max-width: calc(768px + 16px * 2);
  margin: 0 auto;
  display: flex;
  min-height: 100%;
  padding: 0 16px;
  flex-direction: column;
`;

export default function App() {
  return (
    <div>
      <Helmet
        titleTemplate="%s - React.js Boilerplate"
        defaultTitle="React.js Boilerplate"
      >
        <meta name="description" content="A React.js Boilerplate application" />
      </Helmet>
      <NavigationBar />
      <Switch>
        <Route exact path="/" component={PaginaInicio} />
        <Route exact path="/paginaInicio" component={PaginaInicio} />
        <Route exact path="/consultaVuelos" component={ConsultaVuelos} />
        <Route exact path="/consultaVuelos/consultarReservas" component={ConsultarReservas} />
        <Route path="/features" component={FeaturePage} />
        <Route path="" component={NotFoundPage} />
      </Switch>
      {/*<Footer />*/}
    </div>
  );
}
