// Interface that all funcitoning AI objects must implement


public abstract class AI {

    protected Household household;


    public abstract Action takeAction(SimulationController _controller);


    public void setOwner(Household _hhld) {
	household = _hhld;
    } //end


    public abstract Skill chooseSkill(SimulationController _controller);


} //end interface
