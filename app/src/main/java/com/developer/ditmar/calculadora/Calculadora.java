package com.developer.ditmar.calculadora;

import java.util.ArrayList;

public class Calculadora {
    private String mainregx = "\\([\\d\\.]+[\\+\\-\\*\\/\\^]+[\\d\\.]+\\)";
    private String sumregx = "[\\d\\.]+\\+[\\d\\.]+";
    private String resregx = "[\\d\\.]+\\-[\\d\\.]+";
    private String mulregx = "[\\d\\.]+\\*[\\d\\.]+";
    private String divregx = "[\\d\\.]+\\/[\\d\\.]+";
    private String powregx = "[\\d\\.]+\\^[\\d\\.]+";
    private String numberregx = "[\\d\\.]+";
    private String cosregx="cos+[\\d\\.]+";
    private String sinregx="sin+[\\d\\.]+";
    private String tanregx="tan+[\\d\\.]+";

    private String logregx="log+[\\d\\.]+";
    private String lnregx="ln+[\\d\\.]+";
    private String expregx="exp+[\\d\\.]+";
    private String sqrtregx="sqrt+[\\d\\.]+";


    //private String lastregx = "[\\+\\*\\^\\/\\-]";
    private String lastregx = "[\\d\\.]+[\\+\\*\\^\\/\\-]+[\\d\\.]+";
    private String expresion;
    public Calculadora(String exp) {
        this.expresion = exp;
    }
    public String solve() {
        ArrayList<String> results;
        do {
            RegularMatch match = new RegularMatch(this.expresion, mainregx);
            results = match.match();
            binaryOp(results);
        } while(results.size() > 0);
        RegularMatch finalmatch;
        do {
            RegularMatch matchpow = new RegularMatch(this.expresion, powregx);
            ArrayList<String> pow = matchpow.match();
            if (pow.size() > 0) {
                powFunction(pow);
            }
            RegularMatch matchdiv = new RegularMatch(this.expresion, divregx);
            ArrayList<String> div = matchdiv.match();
            if (div.size() > 0) {
                divFunction(div);
            }
            RegularMatch matchmul = new RegularMatch(this.expresion, mulregx);
            ArrayList<String> mul = matchmul.match();
            if (mul.size() > 0) {
                mulFunction(mul);
            }
            RegularMatch matchres = new RegularMatch(this.expresion, resregx);
            ArrayList<String> res = matchres.match();
            if (res.size() > 0) {
                resFunction(res);
            }
            RegularMatch matchsum = new RegularMatch(this.expresion, sumregx);
            ArrayList<String> sum = matchsum.match();
            if (sum.size() > 0) {
                sumFunction(sum);
            }
            RegularMatch matchcos = new RegularMatch(this.expresion, cosregx);
            ArrayList<String> cos = matchcos.match();
            if (cos.size() > 0) {
                cosFunction(cos);
            }
            RegularMatch matchsin = new RegularMatch(this.expresion, sinregx);
            ArrayList<String> sin = matchsin.match();
            if (sin.size() > 0) {
                sinFunction(sin);
            }
            RegularMatch matchtan = new RegularMatch(this.expresion, tanregx);
            ArrayList<String> tan = matchtan.match();
            if (tan.size() > 0) {
                tanFunction(tan);
            }
            RegularMatch matchlog = new RegularMatch(this.expresion, logregx);
            ArrayList<String> log = matchlog.match();
            if (log.size() > 0) {
                logFunction(log);
            }
            RegularMatch matchln = new RegularMatch(this.expresion, lnregx);
            ArrayList<String> ln = matchln.match();
            if (ln.size() > 0) {
                lnFunction(ln);
            }
            RegularMatch matchexp = new RegularMatch(this.expresion, expregx);
            ArrayList<String> exp = matchexp.match();
            if (exp.size() > 0) {
                expFunction(exp);
            }
            RegularMatch matchsqrt = new RegularMatch(this.expresion, sqrtregx);
            ArrayList<String> sqrt = matchsqrt.match();
            if (sqrt.size() > 0) {
                sqrtFunction(sqrt);
            }

            finalmatch = new RegularMatch(this.expresion, lastregx);
        }while (finalmatch.match().size() > 0);
        //int control=expresion.length();
        return this.expresion;
    }
    private void powFunction (ArrayList<String> operacion) {
        for (int i = 0; i < operacion.size(); i++) {
            RegularMatch op = new RegularMatch(operacion.get(i), numberregx);
            ArrayList<String> rs = op.match();
            if (rs.size() == 2) {
                Double n1 = Double.parseDouble(rs.get(0));
                Double n2 = Double.parseDouble(rs.get(1));
                Double r = Math.pow(n1, n2);
                String auxcad = operacion.get(i);
                this.expresion = this.expresion.replace(auxcad, r.toString());
            }
        }
    }
    private void divFunction (ArrayList<String> operacion) {
        for (int i = 0; i < operacion.size(); i++) {
            RegularMatch op = new RegularMatch(operacion.get(i), numberregx);
            ArrayList<String> rs = op.match();
            if (rs.size() == 2) {
                Double n1 = Double.parseDouble(rs.get(0));
                Double n2 = Double.parseDouble(rs.get(1));
                Double r = n1 / n2;
                String auxcad = operacion.get(i);
                this.expresion = this.expresion.replace(auxcad, r.toString());
            }
        }
    }
    private void mulFunction (ArrayList<String> operacion) {
        for (int i = 0; i < operacion.size(); i++) {
            RegularMatch op = new RegularMatch(operacion.get(i), numberregx);
            ArrayList<String> rs = op.match();
            if (rs.size() == 2) {
                Double n1 = Double.parseDouble(rs.get(0));
                Double n2 = Double.parseDouble(rs.get(1));
                Double r = n1 * n2;
                String auxcad = operacion.get(i);
                this.expresion = this.expresion.replace(auxcad, r.toString());
            }
        }
    }
    private void resFunction (ArrayList<String> operacion) {
        for (int i = 0; i < operacion.size(); i++) {
            RegularMatch op = new RegularMatch(operacion.get(i), numberregx);
            ArrayList<String> rs = op.match();
            if (rs.size() == 2) {
                float n1 = Float.parseFloat(rs.get(0));
                float n2 = Float.parseFloat(rs.get(1));
                float r = n1 - n2;
                String floate=String.valueOf(r);
                String auxcad = operacion.get(i);
                this.expresion = this.expresion.replace(auxcad, floate);
            }
        }
    }
    private void sumFunction (ArrayList<String> operacion) {
        for (int i = 0; i < operacion.size(); i++) {
            RegularMatch op = new RegularMatch(operacion.get(i), numberregx);
            ArrayList<String> rs = op.match();
            if (rs.size() == 2) {
                Double n1 = Double.parseDouble(rs.get(0));
                Double n2 = Double.parseDouble(rs.get(1));
                Double r = n1 + n2;
                String auxcad = operacion.get(i);
                this.expresion = this.expresion.replace(auxcad, r.toString());
            }
        }
    }
    private void cosFunction (ArrayList<String> operacion) {
        for (int i = 0; i < operacion.size(); i++) {
            RegularMatch op = new RegularMatch(operacion.get(i), numberregx);
            ArrayList<String> rs = op.match();
            if (rs.size() == 1) {
                Double n1 = Double.parseDouble(rs.get(0));
                Double r = Math.cos(n1);
                String auxcad = operacion.get(i);
                this.expresion = this.expresion.replace(auxcad, r.toString());
            }
        }
    }
    private void sinFunction (ArrayList<String> operacion) {
        for (int i = 0; i < operacion.size(); i++) {
            RegularMatch op = new RegularMatch(operacion.get(i), numberregx);
            ArrayList<String> rs = op.match();
            if (rs.size() == 1) {
                Double n1 = Double.parseDouble(rs.get(0));
                Double r = Math.sin(n1);
                String auxcad = operacion.get(i);
                this.expresion = this.expresion.replace(auxcad, r.toString());
            }
        }
    }
    private void tanFunction (ArrayList<String> operacion) {
        for (int i = 0; i < operacion.size(); i++) {
            RegularMatch op = new RegularMatch(operacion.get(i), numberregx);
            ArrayList<String> rs = op.match();
            if (rs.size() == 1) {
                Double n1 = Double.parseDouble(rs.get(0));
                Double r = Math.tan(n1);
                String auxcad = operacion.get(i);
                this.expresion = this.expresion.replace(auxcad, r.toString());
            }
        }
    }
    //desde aqui continuar
    private void logFunction (ArrayList<String> operacion) {
        for (int i = 0; i < operacion.size(); i++) {
            RegularMatch op = new RegularMatch(operacion.get(i), numberregx);
            ArrayList<String> rs = op.match();
            if (rs.size() == 1) {
                Double n1 = Double.parseDouble(rs.get(0));
                Double r = Math.log(n1);
                String auxcad = operacion.get(i);
                this.expresion = this.expresion.replace(auxcad, r.toString());
            }
        }
    }
    private void lnFunction (ArrayList<String> operacion) {
        for (int i = 0; i < operacion.size(); i++) {
            RegularMatch op = new RegularMatch(operacion.get(i), numberregx);
            ArrayList<String> rs = op.match();
            if (rs.size() == 1) {
                Double n1 = Double.parseDouble(rs.get(0));
                Double r = Math.log10(n1);
                String auxcad = operacion.get(i);
                this.expresion = this.expresion.replace(auxcad, r.toString());
            }
        }
    }
    private void expFunction (ArrayList<String> operacion) {
        for (int i = 0; i < operacion.size(); i++) {
            RegularMatch op = new RegularMatch(operacion.get(i), numberregx);
            ArrayList<String> rs = op.match();
            if (rs.size() == 1) {
                Double n1 = Double.parseDouble(rs.get(0));
                Double r = Math.exp(n1);
                String auxcad = operacion.get(i);
                this.expresion = this.expresion.replace(auxcad, r.toString());
            }
        }
    }
    private void sqrtFunction (ArrayList<String> operacion) {
        for (int i = 0; i < operacion.size(); i++) {
            RegularMatch op = new RegularMatch(operacion.get(i), numberregx);
            ArrayList<String> rs = op.match();
            if (rs.size() == 1) {
                Double n1 = Double.parseDouble(rs.get(0));
                Double r = Math.sqrt(n1);
                String auxcad = operacion.get(i);
                this.expresion = this.expresion.replace(auxcad, r.toString());
            }
        }
    }
    // OJO
    private void binaryOp(ArrayList<String> result) {
        for (int i = 0; i < result.size(); i++) {
            RegularMatch powmatch = new RegularMatch(result.get(i), powregx);
            RegularMatch divmatch = new RegularMatch(result.get(i), divregx);
            RegularMatch mulmatch = new RegularMatch(result.get(i), mulregx);
            RegularMatch resmatch = new RegularMatch(result.get(i), resregx);
            RegularMatch summatch = new RegularMatch(result.get(i), sumregx);
            RegularMatch cosmatch = new RegularMatch(result.get(i), cosregx);
            RegularMatch sinmatch = new RegularMatch(result.get(i), sinregx);
            RegularMatch tanmatch = new RegularMatch(result.get(i), tanregx);
            RegularMatch logmatch = new RegularMatch(result.get(i), logregx);
            RegularMatch lnmatch = new RegularMatch(result.get(i), lnregx);
            RegularMatch expmatch = new RegularMatch(result.get(i), expregx);
            RegularMatch sqrtmatch = new RegularMatch(result.get(i), sqrtregx);
            if (powmatch.match().size() > 0) {
                ArrayList<String> operacion = powmatch.match();
                RegularMatch op = new RegularMatch(operacion.get(0), numberregx);
                ArrayList<String> rs = op.match();
                if (rs.size() == 2) {
                    Double n1 = Double.parseDouble(rs.get(0));
                    Double n2 = Double.parseDouble(rs.get(1));
                    Double r = Math.pow(n1, n2);
                    String auxcad = result.get(i);
                    this.expresion = this.expresion.replace(auxcad, r.toString());
                }
            }
            if (divmatch.match().size() > 0) {
                ArrayList<String> operacion = divmatch.match();
                RegularMatch op = new RegularMatch(operacion.get(0), numberregx);
                ArrayList<String> rs = op.match();
                if (rs.size() == 2) {
                    Double n1 = Double.parseDouble(rs.get(0));
                    Double n2 = Double.parseDouble(rs.get(1));
                    Double r = n1 / n2;
                    String auxcad = result.get(i);
                    this.expresion = this.expresion.replace(auxcad, r.toString());
                }
            }
            if (mulmatch.match().size() > 0) {
                ArrayList<String> operacion = mulmatch.match();
                RegularMatch op = new RegularMatch(operacion.get(0), numberregx);
                ArrayList<String> rs = op.match();
                if (rs.size() == 2) {
                    Double n1 = Double.parseDouble(rs.get(0));
                    Double n2 = Double.parseDouble(rs.get(1));
                    Double r = n1 * n2;
                    String auxcad = result.get(i);
                    this.expresion = this.expresion.replace(auxcad, r.toString());
                }
            }
            if (resmatch.match().size() > 0) {
                ArrayList<String> operacion = resmatch.match();
                RegularMatch op = new RegularMatch(operacion.get(0), numberregx);
                ArrayList<String> rs = op.match();
                if (rs.size() == 2) {
                    float n1 = Float.parseFloat(rs.get(0));
                    float n2 = Float.parseFloat(rs.get(1));
                    float r = n1 - n2;
                    String floate=String.valueOf(r);;
                    String auxcad = result.get(i);
                    this.expresion = this.expresion.replace(auxcad, floate);
                }
            }
            if (summatch.match().size() > 0) {
                ArrayList<String> suma = summatch.match();
                RegularMatch op = new RegularMatch(suma.get(0), numberregx);
                ArrayList<String> rs = op.match();
                if (rs.size() == 2) {
                    Double n1 = Double.parseDouble(rs.get(0));
                    Double n2 = Double.parseDouble(rs.get(1));
                    Double r = n1 + n2;
                    String auxcad = result.get(i);
                    this.expresion = this.expresion.replace(auxcad, r.toString());
                }
            }
            if (cosmatch.match().size() > 0) {
                ArrayList<String> cos = cosmatch.match();
                RegularMatch op = new RegularMatch(cos.get(0), numberregx);
                ArrayList<String> rs = op.match();
                if (rs.size() == 1) {
                    Double n1 = Double.parseDouble(rs.get(0));
                    Double r = Math.cos(n1);
                    String auxcad = result.get(i);
                    this.expresion = this.expresion.replace(auxcad, r.toString());
                }
            }
            if (sinmatch.match().size() > 0) {
                ArrayList<String> sin = sinmatch.match();
                RegularMatch op = new RegularMatch(sin.get(0), numberregx);
                ArrayList<String> rs = op.match();
                if (rs.size() == 1) {
                    Double n1 = Double.parseDouble(rs.get(0));
                    Double r = Math.sin(n1);
                    String auxcad = result.get(i);
                    this.expresion = this.expresion.replace(auxcad, r.toString());
                }
            }
            if (tanmatch.match().size() > 0) {
                ArrayList<String> tan = tanmatch.match();
                RegularMatch op = new RegularMatch(tan.get(0), numberregx);
                ArrayList<String> rs = op.match();
                if (rs.size() == 1) {
                    Double n1 = Double.parseDouble(rs.get(0));
                    Double r = Math.tan(n1);
                    String auxcad = result.get(i);
                    this.expresion = this.expresion.replace(auxcad, r.toString());
                }
            }
            //desde aqui
            if (logmatch.match().size() > 0) {
                ArrayList<String> log = logmatch.match();
                RegularMatch op = new RegularMatch(log.get(0), numberregx);
                ArrayList<String> rs = op.match();
                if (rs.size() == 1) {
                    Double n1 = Double.parseDouble(rs.get(0));
                    Double r = Math.log(n1);
                    String auxcad = result.get(i);
                    this.expresion = this.expresion.replace(auxcad, r.toString());
                }
            }
            if (lnmatch.match().size() > 0) {
                ArrayList<String> ln = lnmatch.match();
                RegularMatch op = new RegularMatch(ln.get(0), numberregx);
                ArrayList<String> rs = op.match();
                if (rs.size() == 1) {
                    Double n1 = Double.parseDouble(rs.get(0));
                    Double r = Math.log10(n1);
                    String auxcad = result.get(i);
                    this.expresion = this.expresion.replace(auxcad, r.toString());
                }
            }
            if (expmatch.match().size() > 0) {
                ArrayList<String> exp = expmatch.match();
                RegularMatch op = new RegularMatch(exp.get(0), numberregx);
                ArrayList<String> rs = op.match();
                if (rs.size() == 1) {
                    Double n1 = Double.parseDouble(rs.get(0));
                    Double r = Math.exp(n1);
                    String auxcad = result.get(i);
                    this.expresion = this.expresion.replace(auxcad, r.toString());
                }
            }
            if (sqrtmatch.match().size() > 0) {
                ArrayList<String> sqrt = sqrtmatch.match();
                RegularMatch op = new RegularMatch(sqrt.get(0), numberregx);
                ArrayList<String> rs = op.match();
                if (rs.size() == 1) {
                    Double n1 = Double.parseDouble(rs.get(0));
                    Double r = Math.sqrt(n1);
                    String auxcad = result.get(i);
                    this.expresion = this.expresion.replace(auxcad, r.toString());
                }
            }
        }
    }
}
