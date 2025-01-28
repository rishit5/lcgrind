class H2O {

    Semaphore hydro;
    Semaphore oxy;
    Phaser ph;

    public H2O() {
        this.hydro = new Semaphore(2);
        this.oxy = new Semaphore(1);
        this.ph = new Phaser(3);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		this.hydro.acquire(1);
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        this.ph.arriveAndAwaitAdvance();
        this.hydro.release(1);
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        this.oxy.acquire(1);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        this.ph.arriveAndAwaitAdvance();
        this.oxy.release(1);
    }
}