export default (props) => (
    <div className="row">
        <div className="offset-3 col-6 offset-3">
            <h1>
                <i className="fa fa-caret-square-o-right" style="font-size:36px"></i>
                {props.videotitle}
            </h1>
            <h3><b>Teacher:</b>{props.teacher}</h3>
        </div>
    </div>
)