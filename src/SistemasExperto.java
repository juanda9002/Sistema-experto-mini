
import Rule.*;

/**
 *
 * @author JuanDavid
 */
public class SistemasExperto {

    BooleanRuleBase basedereglas = new BooleanRuleBase("basedereglas");

    RuleVariable Zapatillas;
    RuleVariable Zapatos;
    RuleVariable Pico;
    RuleVariable Collar;
    RuleVariable OrejasRedondas;
    RuleVariable ResultadoCalzado;
    RuleVariable ResultadoPico;
    RuleVariable ResultadoCollar;
    RuleVariable ResultadoOrejasRedondas;
    String resultado = "";

    //funciones
    public String ObtenerCalzado(String zapatillas, String zapatos) {

        basedeconocimiento();
        Zapatillas.setValue(zapatillas);
        Zapatos.setValue(zapatos);
        basedereglas.forwardChain();
        resultado = ResultadoCalzado.getValue();
        return resultado;
    }

    public String ObtenerResultadoPico(String resultado, String pico) {
        basedeconocimiento();
        ResultadoCalzado.setValue(resultado);
        Pico.setValue(pico);
        basedereglas.forwardChain();
        resultado = ResultadoPico.getValue();
        return resultado;
    }

    public String ObtenerResultadoOrejasRedondas(String resultado, String orejas) {
        basedeconocimiento();
        ResultadoCalzado.setValue(resultado);
        OrejasRedondas.setValue(orejas);
        basedereglas.forwardChain();
        resultado = ResultadoOrejasRedondas.getValue();
        return resultado;
    }

    public String ObtenerResultadoCollar(String resultado, String collar) {
        basedeconocimiento();
        ResultadoCalzado.setValue(resultado);
        Collar.setValue(collar);
        basedereglas.forwardChain();
        resultado = ResultadoCollar.getValue();
        return resultado;
    }

    public void basedeconocimiento() {

        Zapatillas = new RuleVariable(basedereglas, "");
        Zapatos = new RuleVariable(basedereglas, "");
        Pico = new RuleVariable(basedereglas, "");
        Collar = new RuleVariable(basedereglas, "");
        OrejasRedondas = new RuleVariable(basedereglas, "");
        ResultadoCalzado = new RuleVariable(basedereglas, "");
        ResultadoPico = new RuleVariable(basedereglas, "");
        ResultadoCollar = new RuleVariable(basedereglas, "");
        ResultadoOrejasRedondas = new RuleVariable(basedereglas, "");

        Condition igual = new Condition("=");

        //reglas
        Rule reglauno = new Rule(basedereglas, "reglauno",
                new Clause[]{
                    new Clause(Zapatillas, igual, "si"),
                    new Clause(Zapatos, igual, "no")},
                new Clause(ResultadoCalzado, igual, "tieneZapatillas")
        );

        Rule reglados = new Rule(basedereglas, "reglados",
                new Clause[]{
                    new Clause(Zapatillas, igual, "no"),
                    new Clause(Zapatos, igual, "si")},
                new Clause(ResultadoCalzado, igual, "tieneZapatos")
        );

        Rule reglatres = new Rule(basedereglas, "reglatres",
                new Clause[]{
                    new Clause(Zapatillas, igual, "no"),
                    new Clause(Zapatos, igual, "no")},
                new Clause(ResultadoCalzado, igual, "noTieneCalzado")
        );

        Rule reglacuatro = new Rule(basedereglas, "reglacuatro",
                new Clause[]{
                    new Clause(ResultadoCalzado, igual, "tieneZapatillas"),
                    new Clause(Pico, igual, "si")},
                new Clause(ResultadoPico, igual, "Daysi")
        );

        Rule reglacinco = new Rule(basedereglas, "reglacinco",
                new Clause[]{
                    new Clause(ResultadoCalzado, igual, "tieneZapatillas"),
                    new Clause(Pico, igual, "no")},
                new Clause(ResultadoPico, igual, "Minnie")
        );

        Rule reglaseis = new Rule(basedereglas, "reglaseis",
                new Clause[]{
                    new Clause(ResultadoCalzado, igual, "tieneZapatos"),
                    new Clause(OrejasRedondas, igual, "si")},
                new Clause(ResultadoOrejasRedondas, igual, "Mickey")
        );

        Rule reglasiete = new Rule(basedereglas, "reglasiete",
                new Clause[]{
                    new Clause(ResultadoCalzado, igual, "tieneZapatos"),
                    new Clause(OrejasRedondas, igual, "no")},
                new Clause(ResultadoOrejasRedondas, igual, "Godfy")
        );

        Rule reglaocho = new Rule(basedereglas, "reglaocho",
                new Clause[]{
                    new Clause(ResultadoCalzado, igual, "noTieneCalzado"),
                    new Clause(Collar, igual, "si")},
                new Clause(ResultadoCollar, igual, "Pluto")
        );

        Rule reglanueve = new Rule(basedereglas, "reglanueve",
                new Clause[]{
                    new Clause(ResultadoCalzado, igual, "noTieneCalzado"),
                    new Clause(Collar, igual, "no")},
                new Clause(ResultadoCollar, igual, "Donald")
        );
    }
}
