import React from 'react'
import NavBar from '../../components/NavBar'
import Subjects from '../../components/Subjects';

export default class index extends React.Component {
   
    constructor(props) {
        super(props)
    }

    render() {
        return(
            <div>
                <NavBar />
                <Subjects />
            </div>
        )
    }
}