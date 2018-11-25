import SearchBar from './SearchBar'
import React from 'react'
import axios from '../util/axios'
import Router from 'next/router'
import Head from 'next/head';
import Line from '../components/Line'
import ButtonS from '../components/ButtonS'


export default class NavBar extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      profile: {
        studentId: '',
        firstname: '',
        lastname: '',
      }
    }
  }

  async componentDidMount() {
    let user = localStorage.getItem('profileId')
    let { data } = await axios.get('profile-service/profile/' + user)
    this.setState({ profile: data })
    console.log(data)
  }



  render() {
    return (

      <nav className="navbar navbar-expand-lg navbar navbar-dark bg-dark" style={{ marginBottom: '50px' }}>
        <div className="col-md-2">
          <a className="navbar-brand" href="/"><i className="fa fa-cloud" style={{ fontSize: 18, color: 'white' }}></i> Dream-Learning </a>
          <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
        </div>
        <div className="col-md-4">
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav mr-auto">
              <li className="nav-item active">
                <a id="home" className="nav-link" href="/">Home <span className="sr-only">(current)</span></a>
              </li>
              <li>
                <a id="subjects" className="nav-link" href="/subjects">Curriculum <span className="sr-only">(current)</span></a>
              </li>
            </ul>
          </div>
        </div>

        <div className="col-md-3">
          <SearchBar handleOnSearch={this.props.handleOnSearch} />
        </div>
        <div className="col-md-3" style={{ fontSize: 18, color: 'white' }}>
          {this.state.profile.studentId}
          {this.state.profile.firstname} {this.state.profile.lastname}
        </div>

      </nav >

    )
  }
}