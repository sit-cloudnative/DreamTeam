import React from 'react'
import Profile from '../../components/Profile'
import NavBar from '../../components/NavBar'

export default class index extends React.Component {
    constructor() {
        super()
    }

    render() {
        return(
            <div>
                <NavBar />
                <Profile />
            </div>
        ) 
    }
}
