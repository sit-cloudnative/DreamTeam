import React from 'react'
import 'isomorphic-fetch'

export default class SubjectList extends React.Component {

    constructor() {
        super()
        this.state = {
            curriculum: [],
            subjectList: []
        }
        this.getSubjectList = this.getSubjectList.bind(this)
    }

    async componentDidMount() {
        const response = await fetch('http://localhost:8080/curriculum/')
        const curriculum = await response.json()
        this.setState({ curriculum: curriculum })
    }

    async getSubjectList(id) {
        let curriculumId = id.target.value
        const response = await fetch('http://localhost:8080/subjectlist/curriculum/' + curriculumId)
        const subjectList = await response.json()
        this.setState({ subjectList: subjectList })
    }

    render() {
        return (
            <div>
                <div>
                    {this.state.curriculum.map(curriculum =>
                            <button onClick={this.getSubjectList} value={curriculum.curriculumId}>
                                {curriculum.curriculumCode}
                            </button>
                    )}
                </div>
                <div>
                    {this.state.subjectList.map(subject =>
                        <ul>
                            <p><b>subject id: </b> {subject.subject_id}</p>
                            <p><b>subject name: </b> {subject.subject_name}</p>
                            <p><b>subject description: </b> {subject.subject_description}</p>
                            <hr />
                        </ul>
                    )}
                </div>
            </div>
        )
    }
}