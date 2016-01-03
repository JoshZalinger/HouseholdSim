// Interface that all funcitoning AI objects must implement


public abstract class AI {

    private Household household;


    public AI(Household _hhld) {
	household = _hhld;
    } //end


    public abstract Action takeAction();


} //end interface
