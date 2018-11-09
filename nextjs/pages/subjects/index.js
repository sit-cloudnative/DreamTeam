import React from 'react'
import NavBar from '../../components/NavBar'
import SubjectList from '../../components/SubjectList';
import axios from '../../util/axios'

export default class index extends React.Component {

    constructor(props) {
        super(props)
        this.state = {

        }
    }

    render() {
        return (
            <div>
                <NavBar />
                <SubjectList />
            </div>
        )
    }
}