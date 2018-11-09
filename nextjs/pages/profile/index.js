import React from 'react'
import Profile from '../../components/Profile'
import NavBar from '../../components/NavBar'
import Footer from '../../components/Footer'

export default class index extends React.Component {
    constructor() {
        super()
    }

    render() {
        return(
            <div>
                <NavBar />
                <Profile />
                <Footer />
            </div>
        ) 
    }
}
